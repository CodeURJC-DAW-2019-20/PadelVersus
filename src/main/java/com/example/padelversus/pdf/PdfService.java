package com.example.padelversus.pdf;

import com.example.padelversus.tournament.display.TeamDisplay;
import com.example.padelversus.tournament.display.TournamentDisplay;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PdfService implements WebMvcConfigurer {

    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "pdf_temp");


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/pdf_temp/**")
                .addResourceLocations("file:" + FILES_FOLDER.toAbsolutePath().toString() + "/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    public void createPdf(List<TournamentDisplay> tournaments) throws IOException, DocumentException {

        Path file = FILES_FOLDER.resolve("report.pdf");
        FileOutputStream fos = new FileOutputStream(file.toFile());

        Document document = new Document();
        PdfWriter.getInstance(document, fos);
        document.open();
        for (TournamentDisplay tournament : tournaments) {
            PdfPTable table = new PdfPTable(4);
            // Table header
            Stream.of("Team name", "Played", "Won", "Lost")
                    .forEach(columnTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(columnTitle));
                        table.addCell(header);
                    });

            // Rows (one for each team in the tournament)
            for (TeamDisplay team : tournament.getTeams()) {
                table.addCell(team.getName());
                table.addCell(String.valueOf(team.getGamesPlayed()));
                table.addCell(String.valueOf(team.getGamesWon()));
                table.addCell(String.valueOf(team.getGamesLost()));
            }
            document.add(table);
        }
        document.close();
    }

    @PreDestroy
    private void destroy(){
        if(deleteDirectory(FILES_FOLDER.toFile())) System.out.println("Borrados pdfs temporales");
    }

    private boolean deleteDirectory(File directory){
        File [] allContent = directory.listFiles();
        if(allContent != null){
            for(File file: allContent){
                if(file.getName().equals(".gitkeep")) continue;
                System.out.println("Borro" + file);
                deleteDirectory(file);
            }
        }
        if(!directory.getName().equals(FILES_FOLDER.toString())) return directory.delete();
        return true;
    }
}
