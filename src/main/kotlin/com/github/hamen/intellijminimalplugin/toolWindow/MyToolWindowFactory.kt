package com.github.hamen.intellijminimalplugin.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.intellij.util.ui.components.BorderLayoutPanel
import javax.swing.DefaultComboBoxModel
import javax.swing.JPanel

class MyToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        fun getContent() =
            BorderLayoutPanel().apply {
                val zoomLevels = arrayOf("100%", "125%", "150%", "175%", "200%", "300%")
                val comboBox1 = ComboBox(DefaultComboBoxModel(zoomLevels))

                val fontSizes = arrayOf("12", "14", "15", "20", "25", "40")
                val comboBox2 = ComboBox(DefaultComboBoxModel(fontSizes))

                val letters = arrayOf("A", "B", "C", "D", "E", "F")
                val comboBox3 = ComboBox(DefaultComboBoxModel(letters))

                val randomWords =
                    arrayOf("Cat", "Elephant", "Sun", "Book", "Laughter", "Whisper", "Ocean", "Serendipity lorem ipsum", "Umbrella", "Joy")
                val comboBox4 = ComboBox(DefaultComboBoxModel(randomWords))

                val wrapperPanel = JPanel()
                wrapperPanel.add(comboBox1)
                wrapperPanel.add(comboBox2)
                wrapperPanel.add(comboBox3)
                wrapperPanel.add(comboBox4)

                addToCenter(wrapperPanel)
        }
    }
}
