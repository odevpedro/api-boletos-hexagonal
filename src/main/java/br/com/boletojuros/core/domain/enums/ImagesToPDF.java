package br.com.boletojuros.core.domain.enums;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

public class ImagesToPDF {
    public static void main(String[] args) {
        String inputFolder = "caminho"; // Altere para o diretório correto
        String outputPdf = "output.pdf";

        try {
            PDDocument document = new PDDocument();
            File folder = new File(inputFolder);

            // Lista e ordena as imagens
            File[] imageFiles = folder.listFiles((dir, name) -> name.toLowerCase().matches(".*\\.(png|jpg|jpeg)"));
            if (imageFiles == null || imageFiles.length == 0) {
                System.out.println("Nenhuma imagem encontrada!");
                return;
            }

            // Ordena os arquivos e inverte a ordem
            List<File> imageList = Arrays.asList(imageFiles);
            Collections.sort(imageList); // Ordenação padrão (ordem alfabética)
            Collections.reverse(imageList); // Inverte a lista para que as últimas sejam as primeiras

            for (File imageFile : imageList) {
                BufferedImage bufferedImage = ImageIO.read(imageFile);
                PDImageXObject image = PDImageXObject.createFromFile(imageFile.getAbsolutePath(), document);
                PDPage page = new PDPage(new PDRectangle(bufferedImage.getWidth(), bufferedImage.getHeight()));
                document.addPage(page);

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.drawImage(image, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
                }
            }

            document.save(outputPdf);
            document.close();
            System.out.println("PDF criado com sucesso na ordem invertida: " + outputPdf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}