import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.example.Example;
import syntaxhighlighter.theme.ThemeRDark;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(final String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // the SyntaxHighlighter parser
                SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
                // turn HTML script on
                parser.setHtmlScript(true);
                // set HTML Script brushes
                parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));
                // initialize the highlighter and use RDark theme
                SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
                try {
                    highlighter.setContent(new File(args[0]));
                } catch (IOException ex) {
                    Logger.getLogger(Example.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<File> allFiles = FileUtils.getAllFilesRecursivley(new File(args[0].substring(0,
                        args[0].lastIndexOf((char)92))), false);

                ArrayList<String> fileLocations = new ArrayList<String>();

                for (File singleFile : allFiles){
                    fileLocations.add(singleFile.getAbsolutePath());
                }

                final JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(highlighter);
                frame.setLocationByPlatform(true);
                frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
                frame.setTitle(args[0].substring(args[0].lastIndexOf((char) 92) + 1));
                frame.setFocusable(true);
                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == 39) {
                            int currentIndex = fileLocations.indexOf(args[0]);
                            if (currentIndex < fileLocations.size() - 1) {
                                currentIndex++;
                            } else {
                                currentIndex = 0;
                            }
                            main(new String[]{fileLocations.get(currentIndex)});
                            frame.dispose();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
