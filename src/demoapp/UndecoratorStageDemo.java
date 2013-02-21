/*
 * Copyright (c) 2013, Arnaud Nouard
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the In-SideFX nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * Demo purpose
 * In-SideFX (Un)decorator for JavaFX stage
 * License: You can use this code for any kind of purpose, commercial or not.
 */
package demoapp;

import insidefx.undecorator.Undecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author in-sideFX
 */
public class UndecoratorStageDemo extends Application {

    @Override
    public void start(final Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("ClientArea.fxml"));
        Undecorator undecorator = new Undecorator(stage, root);
        // Customize it by CSS if needed:
        undecorator.getStylesheets().add("skin/undecorator.css");
        
        // Optional: Enable this node to drag the stage
        // By default the root argument of Undecorator is set as draggable
        Node node = root.lookup("#draggableNode");
        undecorator.setAsStageDraggable(stage, node);
        
        Scene scene = new Scene(undecorator);

        // Transparent scene and stage
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        // Set minimum size
        stage.setMinWidth(500);
        stage.setMinHeight(400);

        stage.setTitle("No title bar");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
