package com.example.taller_4;

import com.google.gson.Gson;

import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static com.example.taller_4.Constants.UPLOAD_DIRECTORY;

@WebServlet(name = "submit-img", value = "/Submit-IMG")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImgSubmit extends HttpServlet {
    private String ImageName;
    private String nameUser;
    private Gson gson = new Gson();
    private Archivo archivo = new Archivo(new File("Archivo.txt"));
    private static final long serialVersionUID = 1L;
    private ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            usuarios = archivo.leerArchivo(new File("Archivo.txt"));

            System.out.println("Este es el objeto de los Json"+gson.toJson(usuarios) );


        String Description = request.getParameter("descriptionIMG");
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {

            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);





            }

            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("nameUser")) {
                    nameUser = cookies[i].getValue();
                }
            }
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
            setImageName(fileName);
            String fecha = String.valueOf(LocalDateTime.now());


            addUser(nameUser, fileName, Description, fecha,usuarios);
        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/Formimage.html").forward(request, response);

    }

    private String getFileName(Part part) {
        String fileName = "",
                contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }


    public String getImageName() {
        return ImageName;
    }

    public boolean addUser(String nameUser, String nameImage, String description, String date, ArrayList<Usuario> user) {
        boolean verificar = false;
        Usuario newUser = new Usuario(nameUser, nameImage, description, date);
        user.add(newUser);

        archivo.escribirEnArchivo(user, "Archivo.txt");
        verificar = true;

        return verificar;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }
}

