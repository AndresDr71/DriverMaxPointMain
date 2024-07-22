package demo_jdbc;

import java.util.List;

import demo_jdbc.Repository.DriverResultRepository;
import demo_jdbc.Repository.QueryRepository;
import demo_jdbc.Repository.SeasonRepository;
import demo_jdbc.models.DriverMaxPoint;
import demo_jdbc.models.DriverResult;
import demo_jdbc.models.Season;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DriverMaxPointMain extends Application{
   
	private ObservableList<DriverMaxPoint> driverMaxPoint = FXCollections.observableArrayList();

    public Label createLabel(String texto) {
        Label lbl = new Label(texto);
        lbl.setFont(Font.font("Times New Roman", 18));
        String style = "-fx-font-weight: bold";  // Negrita
        lbl.setStyle(style);
        return lbl;
    }

    public TableView<DriverMaxPoint> createTableView() {
        TableView<DriverMaxPoint> tableView = new TableView<>(driverMaxPoint);
        tableView.setPrefSize(400, 500);
        String style = "-fx-background-color: #20B2AA";
        tableView.setStyle(style);

        TableColumn<DriverMaxPoint, String> tableColumn1 = new TableColumn<>("Driver Name");
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("driverName"));

        TableColumn<DriverMaxPoint, Integer> tableColumn2 = new TableColumn<>("Total Points");
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("points"));

        tableView.getColumns().addAll(tableColumn1, tableColumn2);

        return tableView;
    }

    private void loadInitialData() {
        QueryRepository queryRepository = new QueryRepository();
        List<DriverMaxPoint> results = queryRepository.getDriverMaxPoints();

        driverMaxPoint.clear();
        driverMaxPoint.addAll(results);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("DRIVER RESULTS");
        primaryStage.setScene(scene);
        primaryStage.show();

        VBox vBox = new VBox();
        vBox.setPrefSize(100, 400);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().add(createTableView());

        HBox hBox = new HBox();
        hBox.setPrefSize(40, 10);
        hBox.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setTop(createLabel("Resultado de Drivers Max Points"));
        root.setCenter(hBox);
        root.setBottom(vBox);

        // Load the initial data when the application starts
        loadInitialData();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
