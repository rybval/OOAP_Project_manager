package ru.unn.ooap.projectmanager.client.presenter;

import ru.unn.ooap.projectmanager.server.model.users.User;

import java.io.IOException;

public interface IAuthView {
    void setUser(User user);
    void showScene(String fxmlFile) throws IOException;
}