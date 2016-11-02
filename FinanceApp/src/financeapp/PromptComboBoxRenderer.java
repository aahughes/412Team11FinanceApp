/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeapp;

/**
 *
 * @author aah5307
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

class PromptComboBoxRenderer extends BasicComboBoxRenderer
{
	private String prompt;

	/*
	 *  Set the text to display when no item has been selected.
	 */
	public PromptComboBoxRenderer(String prompt)
	{
		this.prompt = prompt;
	}

	/*
	 *  Custom rendering to display the prompt text when no item is selected
	 */
        @Override
	public Component getListCellRendererComponent(
		JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		if (value == null)
			setText( prompt );

		return this;
	}
}