package application;

import br.com.hospitalif.DAO.MedicoDAO;
import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Medico;
import br.com.hospitalif.util.Rotas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main extends Application {

    static Stage stageAtual;
    static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws Exception {
        stageAtual = stage;
        loader = new FXMLLoader(getClass().getResource(Rotas.LOGIN));
        Scene scene = new Scene((Parent) loader.load());
        scene.getStylesheets().add(getClass().getResource("/CSS/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public void openPage(String rota) throws Exception {

        loader = new FXMLLoader(getClass().getResource(rota));
        Scene scene = new Scene((Parent) loader.load());
        scene.getStylesheets().add(getClass().getResource("/CSS/app.css").toExternalForm());
        stageAtual.setScene(scene);
        stageAtual.show();

    }

    public Main(){
        //ConnectionClass conn = new ConnectionClass();
        //conn.getConnection();

        //System.out.println(conn.getStatus());
    }

    public static void main(String[] args) throws SQLException {
        //launch(args);

        Medico m = new Medico();
        m.setNumeroRegistro("12345-8");
        m.setEspecialidade("Oftalmo");
        m.setIdFuncionario(1);

        MedicoDAO mDAO = new MedicoDAO();
        mDAO.save(m);

    }
}
