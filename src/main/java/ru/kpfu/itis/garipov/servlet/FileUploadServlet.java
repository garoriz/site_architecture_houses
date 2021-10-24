package ru.kpfu.itis.garipov.servlet;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class FileUploadServlet extends HttpServlet {
    private static final int DIRECTORIES_COUNT = 100;
    private static final String FILE_PATH_PREFIX = "/tmp";
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dfn48aqa5",
            "api_key", "591695994741495",
            "api_secret", "fWcdsdRM6uR3o5NdZDGAzVli5bo"));
    UserServiceImpl userService = new UserServiceImpl();
    Date date = new Date();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        if (sessionUser == null) {
            resp.sendRedirect("/login");
        } else {
            req.getRequestDispatcher("upload.ftl").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");

        Part part = req.getPart("file");
        if (part.getSize() == 0) {
            resp.sendRedirect("/upload");
        } else {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            InputStream content = part.getInputStream();
            int partNumber = Math.abs(fileName.hashCode() % DIRECTORIES_COUNT);
            File file = new File(FILE_PATH_PREFIX + File.separator + partNumber + File.separator + fileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[content.available()];
            content.read(buffer);
            outputStream.write(buffer);
            String publicId = sessionUser + new Date().getTime();
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", publicId));
            userService.changeUrlPhoto(sessionUser, cloudinary.url().transformation(new Transformation().width(100)
                            .height(111)).imageTag(publicId));

            resp.sendRedirect("/profile");
        }
    }
}
