package report;

import br.com.hospitalif.connectivity.ConnectionClass;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PrintReport extends JFrame {

    public void showReport(String relatorio) throws JRException,ClassNotFoundException, SQLException {

        String reportSrcFile = "resource/report/" + relatorio;

        // Compilar o arquivo jrxml
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

        // Colocar os parâmetros em uma Collection caso precise
        HashMap<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("parametros aqui", "valor dos parâmetros");

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        list.add(parameters);

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);

        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, new ConnectionClass().getConnection());


        JRViewer viewer = new JRViewer(print);

        viewer.setOpaque(true);

        viewer.setVisible(true);

        this.add(viewer);

        this.setSize(700, 500);

        this.setVisible(true);

        System.out.print("Relatório Gerado!");

    }

}
