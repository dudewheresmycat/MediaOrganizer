package gabeAndJakeFinalProject.mediaOrganizer;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MediaOrganizerController implements Initializable {

	@FXML
	private TableColumn<Songs, String> artistColumn;

	@FXML
	private TableColumn<Songs, Duration> timeColumn;

	@FXML
	private TableColumn<Songs, String> nameColumn;

	@FXML
	private TableColumn<Songs, String> genreColumn;

	@FXML
	private TableColumn<Songs, String> albumColumn;

	@FXML
	private TableView<Songs> tableView;

	@FXML
	private Button pauseTrack;

	@FXML
	private Button previousTrack;

	@FXML
	private Button nextTrack;

	@FXML
	private Button playTrack;
	//REQ #8
	@Override
	public void initialize(URL fxml, ResourceBundle resources) {
		this.artistColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("artist"));
		this.albumColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("album"));
		this.genreColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("genre"));
		this.nameColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("title"));
		this.timeColumn.setCellValueFactory(new PropertyValueFactory<Songs, Duration>("duration"));
	}
}