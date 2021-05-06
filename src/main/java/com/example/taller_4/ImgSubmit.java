package com.example.taller_4;
import com.google.gson.Gson;

import com.google.gson.Gson;

import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.stream.Collectors;


import static com.example.taller_4.Constants.UPLOAD_DIRECTORY;

@WebServlet(name = "submit-img", value = "/Submit-IMG")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ImgSubmit extends HttpServlet {
    private String ImageName;
    private String nameUser;
    private Gson gson = new Gson();

    private Archivo archivo;
    private static final long serialVersionUID = 1L;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private String x = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Description = request.getParameter("descriptionIMG");
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        try {

            x = uploadPath + File.separator;

            archivo = new Archivo(new File(x + "Archivo.txt"));
            usuarios = archivo.leerArchivo(new File(x + "Archivo.txt"));
        } catch (Exception e) {

        }

        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {

            String fileName = "";
            for (Part part :  request.getParts().stream().filter(part -> "imageSUB".equals(part.getName())).collect(Collectors.toList())) {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
            }

            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("userName")) {
                    nameUser = cookies[i].getValue();
                }
            }
            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
            setImageName(fileName);
            Date fecha = new Date();

            x = uploadPath + File.separator ;
            archivo = new Archivo(new File(x+"/Archivo.txt"));

            addUser(nameUser, fileName, Description, usuarios);
            usuarios = archivo.leerArchivo(new File(x+"/Archivo.txt"));

            String j = gson.toJson(usuarios);

            crearJson(j,x);


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

    public boolean addUser(String nameUser, String nameImage, String description, ArrayList<Usuario> user) {
        boolean verificar = false;
       String nameIMG = "/target/taller-4-1.0-SNAPSHOT/upload/"+nameImage;
        Date myDate = new Date();
        String FechaFinal = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
        Usuario newUser = new Usuario(nameUser, nameIMG, description, FechaFinal);
        System.out.println("Nombre de usuario" + nameUser);
        user.add(newUser);
        archivo.escribirEnArchivo(user, x + "Archivo.txt");
        verificar = true;

        return verificar;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }


    public void crearJson(String jso, String na) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(na + "Data.json"))) {
            bw.write(jso);
            System.out.println("Fichero creado");
        } catch (IOException ex) {
            Logger.getLogger(ImgSubmit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
