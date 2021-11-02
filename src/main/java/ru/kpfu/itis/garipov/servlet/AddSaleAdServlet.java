package ru.kpfu.itis.garipov.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import ru.kpfu.itis.garipov.model.Article;
import ru.kpfu.itis.garipov.model.SaleAd;
import ru.kpfu.itis.garipov.service.impl.ArticleServiceImpl;
import ru.kpfu.itis.garipov.service.impl.SaleAdServiceImpl;
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

@WebServlet(name = "addSaleAdServlet", urlPatterns = "/addSaleAd")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class AddSaleAdServlet extends HttpServlet {
    private static final int DIRECTORIES_COUNT = 100;
    private static final String FILE_PATH_PREFIX = "/tmp";
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dfn48aqa5",
            "api_key", "591695994741495",
            "api_secret", "fWcdsdRM6uR3o5NdZDGAzVli5bo"));

    SaleAdServiceImpl saleAdService = new SaleAdServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add_sale_ad.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        String heading = req.getParameter("heading");
        String content = req.getParameter("content");
        int price = Integer.parseInt(req.getParameter("price"));
        String phoneNumber = req.getParameter("phoneNumber");
        String urlPhoto = "";

        Part part = req.getPart("file");
        if (part.getSize() != 0) {
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            InputStream contentPhoto = part.getInputStream();
            int partNumber = Math.abs(fileName.hashCode() % DIRECTORIES_COUNT);
            File file = new File(FILE_PATH_PREFIX + File.separator + partNumber + File.separator + fileName);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[contentPhoto.available()];
            contentPhoto.read(buffer);
            outputStream.write(buffer);
            String publicId = sessionUser + new Date().getTime();
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", publicId));
            urlPhoto = cloudinary.url().transformation(new Transformation().width(1000)
                    .height(500)).imageTag(publicId);
        }


        saleAdService.save(new SaleAd(
                userService.get(sessionUser).getId(),
                heading,
                content,
                price,
                phoneNumber,
                urlPhoto
        ));
        resp.sendRedirect("/saleAds");
    }
}
