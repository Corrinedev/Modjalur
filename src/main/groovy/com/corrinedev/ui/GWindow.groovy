package com.corrinedev.ui

import com.corrinedev.Launcher

import javax.swing.AbstractAction
import javax.swing.Action
import javax.swing.JApplet
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.LookAndFeel
import javax.swing.SpringLayout
import javax.swing.SwingUtilities
import javax.swing.UIManager
import javax.swing.plaf.basic.BasicInternalFrameTitlePane
import java.applet.Applet
import java.awt.Component
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Graphics
import java.awt.LayoutManager
import java.awt.PopupMenu
import java.awt.Toolkit
import java.awt.event.ActionEvent

class GWindow extends JFrame {
    String currentTitle
    GWindow(int w, int h) {
        this.setBounds(Toolkit.defaultToolkit.screenSize.width / 2 as int, Toolkit.defaultToolkit.screenSize.height / 2 as int, w, h)
    }

    @Override
    void repaint() {
        super.repaint()
        currentTitle = Launcher.launcherSettings.title + ": ${Runtime.runtime.freeMemory() / (1024 * 1024) as int}mb / ${Runtime.runtime.totalMemory() / (1024 * 1024) as int}mb"
        this.setTitle(currentTitle)
    }

    def init() {
        this.setDefaultCloseOperation(2)
        this.setLayout(new SpringLayout())
        this.setVisible(true)

        this.setJMenuBar(new JMenuBar(){{
            setBounds(0,0, width, 80)
            add(new JMenu("MenuItem"){{
                add("item1")
            }})
        }})

        this.add(new JButton("Instances"){{
            action = [
                    actionPerformed: { ActionEvent e ->
                        swapScreen()
                    }
            ] as AbstractAction
            setPreferredSize(new Dimension(160, 80))
        }})
        this.add(new JButton("Settings"){{
            action = [
                    actionPerformed: { ActionEvent e ->
                        swapScreen()
                    }
            ] as AbstractAction
            setPreferredSize(new Dimension(160, 80))
        }})
    }

    def swapScreen() {
        println 'screen swapped'
    }
}
