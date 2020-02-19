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
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

@Component
public class PdfGenerator {

    public void createPdf(List<TournamentDisplay> tournaments) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jllav\\OneDrive\\Escritorio\\testDocument.pdf"));
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
}
