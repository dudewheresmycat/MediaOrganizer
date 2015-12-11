package gabeAndJakeFinalProject.mediaOrganizer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaView;
import javafx.util.Callback;
import javafx.util.Duration;

public class MediaOrganizerController {

	public ObservableList<Songs> data;
	@FXML
    private ListView<String> listView;
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
	private MediaView mediaView;

	@FXML
	private Button pauseTrack;

	@FXML
	private Button previousTrack;

	@FXML
	private Button nextTrack;

	@FXML
	private Button playTrack;
	
    @FXML
    private Button refresh;
    @FXML
    private TextField folderToUse;
    public void refreshButtonListener(ActionEvent event) throws UnsupportedTagException, InvalidDataException, SQLException, IOException{
    	String filepath = folderToUse.getText();
    	MediaDB.createDatabase(filepath);
    	initialize();
    }
	
	public void initialize(){
		ObservableList<String> list = FXCollections.observableArrayList(MediaDB.getMedia());
		listView.setItems(list);
	}
//	@Override
//	public void initialize(URL fxml, ResourceBundle resources) {
//		this.artistColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("artist"));
//		this.albumColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("album"));
//		this.genreColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("genre"));
//		this.nameColumn.setCellValueFactory(new PropertyValueFactory<Songs, String>("title"));
//		this.timeColumn.setCellValueFactory(new PropertyValueFactory<Songs, Duration>("duration"));
//
//	}

//	@SuppressWarnings({ "unchecked", "rawtypes", "rawtypes" })
//	public void buildData() {
//		final String DB_URL ="jdbc:derby:db/Media/Media";
//		Connection c;
//		data = FXCollections.observableArrayList();
//		try {
//			c = DriverManager.getConnection(DB_URL);
//			String SQL = "SELECT * FROM Media";
//			ResultSet rs = c.createStatement().executeQuery(SQL);
//			/**********************************
//			 * TABLE COLUMN ADDED DYNAMICALLY *
//			 **********************************/
//			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//				// We are using non property style for making dynamic table
//				final int j = i;
//				@SuppressWarnings("rawtypes")
//				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//				col.setCellValueFactory(
//						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//							@SuppressWarnings({ "unchecked", "unchecked" })
//							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
//								return new SimpleStringProperty(param.getValue().get(j).toString());
//							}
//						});
//				tableView.getColumns().addAll(col);
//				System.out.println("Column [" + i + "] ");
//			}
//			/********************************
//			 * Data added to ObservableList *
//			 ********************************/
//			while (rs.next()) {
//				// Iterate Row
//				ObservableList<String> row = FXCollections.observableArrayList();
//				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//					row.add(rs.getString(i));
//				}
//				System.out.println("Row [1] added " + row);
//				data.add((Songs) row);
//			}
//
//			// FINALLY ADDED TO TableView
//
//			tableView.setItems(data);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//			System.out.println("Error on Building Data");
//
//		}
//	}

	public void playButtonListener(ActionEvent event) {
		tableView.getSelectionModel().getSelectedIndex();
		mediaView.getMediaPlayer().play();
	}

	public void pauseButtonListener(ActionEvent event) {
		mediaView.getMediaPlayer().pause();
	}

	public void nextTrackListener(ActionEvent event) {
	}

	public void previousTrackListener(ActionEvent event) {

	}


	
}