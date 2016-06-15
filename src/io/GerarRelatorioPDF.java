package io;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dto.DTODespesasGrupo;
import dto.DTOReceitasGrupo;


public class GerarRelatorioPDF {
	
	Document document;
	
	private static Font catFont=new Font(Font.FontFamily.TIMES_ROMAN,18,Font.BOLD);
	private static Font catFontSub=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
	
	public GerarRelatorioPDF() {
		document = new Document();
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public static Font getCatFont() {
		return catFont;
	}

	public static void setCatFont(Font catFont) {
		GerarRelatorioPDF.catFont = catFont;
	}
	
	public void addMetaData(){
		document.addTitle("Relatório de Despesas e Receitas");
		document.addAuthor("FinanGroup");
	}
	
	public void addLinhaEmBranco(Paragraph paragrafo, int number){
		for(int i =0; i<number;i++){
			paragrafo.add(new Paragraph(" "));
		}
	}
	
	public Paragraph addTituloPrincipal(){
		Paragraph preface = new Paragraph();
		addLinhaEmBranco(preface, 2);
		preface.add(new Paragraph("Relatório de Despesas e Receitas",catFont));
		addLinhaEmBranco(preface, 3);
		return preface;
	}
	
	public Paragraph addTituloReceita(){
		Paragraph preface = new Paragraph();
		addLinhaEmBranco(preface, 1);
		preface.add(new Paragraph("Receitas:",catFontSub));
		addLinhaEmBranco(preface, 1);
		return preface;
	}
	
	public Paragraph addTituloDespesa(){
		Paragraph preface = new Paragraph();
		addLinhaEmBranco(preface, 2);
		preface.add(new Paragraph("Despesas:",catFontSub));
		addLinhaEmBranco(preface, 1);
		return preface;
	}
	
	public PdfPTable addConteudoDespesas(List<DTODespesasGrupo> despesas){
		PdfPCell cell = new PdfPCell();
		PdfPTable table = new PdfPTable(4);
		
		
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Data Vencimento"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Nome da Despesa"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Valor"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Usuario que Lançou"));
		table.addCell(cell);
		
		for(DTODespesasGrupo dto : despesas){
			table.addCell(String.valueOf(dto.getDataVencimento()));
			table.addCell(dto.getNomeLancamento());
			table.addCell(String.valueOf(dto.getValorLancamento()));
			table.addCell(dto.getUsuarioLancador());
		}
		return table;
	}
	
	public PdfPTable addConteudoReceitas(List<DTOReceitasGrupo> receitas){
		PdfPCell cell = new PdfPCell();
		PdfPTable table = new PdfPTable(4);
		
		
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Data Lancamento"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Nome da Receita"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Valor"));
		table.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(new Phrase("Usuario que Lançou"));
		table.addCell(cell);
		
		for(DTOReceitasGrupo dto : receitas){
			table.addCell(String.valueOf(dto.getDataVencimento()));
			table.addCell(dto.getNomeLancamento());
			table.addCell(String.valueOf(dto.getValorLancamento()));
			table.addCell(dto.getUsuarioLancador());
		}
		return table;
	}
	
	public void gerarPDF(List<DTOReceitasGrupo> receitas, List<DTODespesasGrupo> despesas ){
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("c:/relatoriosPDFItext/relatorioDespesaReceita.pdf"));
			document.open();
			Image img = Image.getInstance("C:/MyWorkspace_BRQ_2/projetoFinalBrq_14/WebContent/img/FinanGroupRelatorio.png");
			img.setAlignment(Element.ALIGN_CENTER);
			document.add(img);
			addMetaData();
			Paragraph p1 = addTituloPrincipal();
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			
			Paragraph p2 = addTituloDespesa();
			p2.setAlignment(Element.ALIGN_CENTER);
			document.add(p2);
			
			document.add(addConteudoDespesas(despesas));
			
			Paragraph p3 = addTituloReceita();
			p3.setAlignment(Element.ALIGN_CENTER);
			document.add(p3);
			
			document.add(addConteudoReceitas(receitas));
			
			document.close();
			
			try{	
				String arg[]=
			{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
		     "c:/relatoriosPDFItext/relatorioDespesaReceita.pdf"};
				 Runtime rt = Runtime.getRuntime();
				 Process p = rt.exec(arg);

			}catch(Exception ex){
				System.out.println("Error :" + ex.getMessage());
			}
			
			
			
		} catch (Exception ex) {

			ex.printStackTrace();
			
			
		}
	}
	
	
	
	
	

}
