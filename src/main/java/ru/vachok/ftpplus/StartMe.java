package ru.vachok.ftpplus;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;

/**
 <b>Точка старта</b>

 @version %I% %G%
 @since 01.05.2018 (20:12) */
public class StartMe extends Application {
    public ImageView imgShow;
    /**
     Вынесем основной фрейм в поле.

     @see #start(Stage)
     */
    private Stage primaryStage;
    /**
     @return {@link #primaryStage}
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     @param primaryStage {@link #primaryStage}
     @return {@link #primaryStage}
     */
    private StartMe setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        return this;
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        Group root;
        root = FXMLLoader.load(getClass().getResource("StartMe.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        setPrimaryStage(primaryStage);
        primaryStage.show();
    }
    public void someTh(ActionEvent actionEvent) {
        File dirImg = new File("g:\\myEX\\");
        File[] imgS = dirImg.listFiles();
        for (File img : imgS) {
            Path path = img.toPath();
            URL url = null;
            try {
                url = path.toUri().toURL();
            } catch (MalformedURLException | NullPointerException e) {
                Dialog dialog = new Dialog();
                dialog.setContentText(Arrays.toString(e.getStackTrace()));
                dialog.setHeaderText(e.getMessage());
                dialog.showAndWait();
            }
            Image image = new Image(url.toString());
            imgShow.setImage(image);
        }
        System.exit(Const.OK.ordinal());
    }
}
