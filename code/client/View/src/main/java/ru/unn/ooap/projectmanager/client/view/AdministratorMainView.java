package ru.unn.ooap.projectmanager.client.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import ru.unn.ooap.projectmanager.client.presenter.admin.IAdministratorMainView;
import ru.unn.ooap.projectmanager.client.presenter.admin.AdministratorMainPresenter;
import ru.unn.ooap.projectmanager.server.model.users.administrator.IUser;

import java.io.IOException;

public class AdministratorMainView extends UserMainView implements IAdministratorMainView {
    @FXML
    private Pane content;
    @FXML
    private ListView<IUser> users;
    @FXML
    private Button createAdministratorButton;
    @FXML
    private Button createManagerButton;
    @FXML
    private Button createExecutorButton;

    @FXML
    private AdministratorMainPresenter presenter;

    @FXML
    void initialize() {
        presenter.setView(this);
        createAdministratorButton.setOnAction(actionEvent -> presenter.createAdministrator());
        createManagerButton.setOnAction(actionEvent -> presenter.createManager());
        createExecutorButton.setOnAction(actionEvent -> presenter.createExecutor());

        users.getSelectionModel().selectedItemProperty().addListener(
                (ov, oldValue, newValue) -> presenter.setSelectedUser(newValue));
    }

    @Override
    public void initUser(final ru.unn.ooap.projectmanager.server.model.users.IUser user) {
        presenter.setUser(user);
    }

    @Override
    public void showUser(
            final ru.unn.ooap.projectmanager.server.model.users.administrator.IUser user)
            throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorUserView.fxml"));
        content.getChildren().clear();
        content.getChildren().add(loader.load());
        AdministratorUserView controller = loader.<AdministratorUserView>getController();
        controller.initUser(user);
        content.getScene().getWindow().sizeToScene();
    }
}
