package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.logic.Logic;


/**
 * TabPane for traversing between different list.
 */
public class MainTabPane extends UiPart<Region> {
    private static final String FXML = "MainTabPane.fxml";

    private Logic logic;
    private PersonListPanel personListPanel;
    private RoomListPanel roomListPanel;
    private MainWindow mainWindow;

    @FXML
    private TabPane mainTabPane;
    @FXML
    private Tab roomTab;
    @FXML
    private Tab guestTab;
    @FXML
    private StackPane personListPlaceholder;
    @FXML
    private StackPane roomListPanelPlaceholder;

    /**
     * Create a mainTabPane
     * @param logic
     */
    public MainTabPane(Logic logic) {
        super(FXML);
        this.logic = logic;


        ///set up personListPanel and roomListPanel
        setPersonListPanel();
        setRoomListPanel();
        mainTabPane.getStyleClass().add("floating");
    }

    private void setPersonListPanel() {
        personListPanel = new PersonListPanel(logic.getFilteredPersonList());
        personListPlaceholder.getChildren().add(personListPanel.getRoot());
    }

    private void setRoomListPanel() {
        roomListPanel = new RoomListPanel(logic.getRoomList());
        roomListPanelPlaceholder.getChildren().add(roomListPanel.getRoot());
    }
}