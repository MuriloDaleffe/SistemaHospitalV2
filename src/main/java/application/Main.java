package application;

import br.com.hospitalif.DAO.*;
import br.com.hospitalif.model.*;
import util.Rotas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main extends Application {

    static Stage stageAtual;
    static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws Exception {

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Rotas.PERSISTENCEUNITNAME);
//        EntityManager entityManager = entityManagerFactory.createEntityManager();

        stageAtual = stage;
        loader = new FXMLLoader(getClass().getResource(Rotas.LOGIN));
        Scene scene = new Scene((Parent) loader.load());
        scene.getStylesheets().add(getClass().getResource("../CSS/app.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    public static void openPage(String rota) throws Exception {

        loader = new FXMLLoader(Main.class.getResource(rota));
        Scene scene = new Scene((Parent) loader.load());
        scene.getStylesheets().add(Main.class.getResource("../CSS/app.css").toExternalForm());
        stageAtual.setScene(scene);
        stageAtual.show();

    }

    public static void main(String[] args) throws SQLException {

        //popularBanco();

        launch(args);

    }

    public static void popularBanco(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Rotas.PERSISTENCEUNITNAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Medico m = new Medico();

        MedicoDAO daoMedico = new MedicoDAO(entityManager);

        m.setNumRegistro("54321");
        m.setEspecialidade("Oftalmologista");
        m.setNome("José Arthur");
        m.setStatusDeUsuario("Ativo");
        m.setLogin("JoseOftalmo2");
        m.setSenha("qwert");
        m.setCpf("987654321");
        m.setIdade(30);
        m.setTipoSanguineo("A-");
        m.setSexo("M");
        m.setStatusDePessoa("Médico");

        daoMedico.salvar(m);

        Gerente g = new Gerente();

        g.setNome("Marcos");
        g.setStatusDeUsuario("Ativo");
        g.setLogin("mg");
        g.setSenha("qwert");
        g.setCpf("987654321");
        g.setIdade(30);
        g.setTipoSanguineo("A-");
        g.setSexo("M");
        g.setStatusDePessoa("Gerente");
        g.setCargo("Gerente Enfermaria");

        GerenteDAO dao = new GerenteDAO(entityManager);

        dao.salvar(g);

        EnfermidadePessoal ep = new EnfermidadePessoal();

        ep.setNome("Nome EF");
        ep.setDescricao("Descrição EF");
        ep.setStatusDeEnfermidade("Status EF");
        ep.setComentario("Comentario EF");
        ep.setTipo("Tipo EF");

        EnfermidadePessoalDAO dao2 = new EnfermidadePessoalDAO(entityManager);

        dao2.salvar(ep);

        Paciente p = new Paciente();

        p.setNome("Nome Pac");
        p.setAltura(new Float(1.8));
        p.setCpf("123456789");
        p.setIdade(22);
        p.setPeso(new Float(75.7));
        p.setSexo("m");
        p.setStatusDePessoa("Status de pessoa P");
        p.setTipoSanguineo("AB-");

        PacienteDAO pacdao = new PacienteDAO(entityManager);

        pacdao.salvar(p);

        Atendente at = new Atendente();

        at.setNome("Bruna");
        at.setStatusDeUsuario("Ativo");
        at.setLogin("mg");
        at.setSenha("qwert");
        at.setCpf("987654321");
        at.setIdade(30);
        at.setTipoSanguineo("A-");
        at.setSexo("F");
        at.setStatusDePessoa("Atendente");
        at.setCargo("Atendente Balcão");

        AtendenteDAO atendenteDAO = new AtendenteDAO(entityManager);

        atendenteDAO.salvar(at);

        Administrador adm = new Administrador();

        adm.setNome("Miguel");
        adm.setStatusDeUsuario("Ativo");
        adm.setLogin("mg");
        adm.setSenha("qwert");
        adm.setCpf("987654321");
        adm.setIdade(30);
        adm.setTipoSanguineo("A-");
        adm.setSexo("M");
        adm.setStatusDePessoa("Administrador");
        adm.setCargo("Administrador ");

        AdministradorDAO administradorDAO = new AdministradorDAO(entityManager);

        administradorDAO.salvar(adm);

        Enfermeiro enf = new Enfermeiro();

        EnfermeiroDAO daoEnfermeiro = new EnfermeiroDAO(entityManager);

        enf.setNumeroDeRegistro("23445");
        enf.setNome("Alexandre");
        enf.setStatusDeUsuario("Ativo");
        enf.setLogin("AlexandreEnfer");
        enf.setSenha("qwert");
        enf.setCpf("987654321");
        enf.setIdade(30);
        enf.setTipoSanguineo("A-");
        enf.setSexo("M");
        enf.setStatusDePessoa("Enfermeiro");

        daoEnfermeiro.salvar(enf);

    }
}
