package hu.okfonok.beans.admin

import hu.okfonok.utils.Config

import javax.inject.Named

import org.apache.commons.io.FileUtils
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("emailEditorBean")
@Scope("view")
class EmailEditorBean implements Serializable{
	String content
	String editedFile

	void saveListener() {
		FileUtils.write(new File("${Config.emailTemplatePath}/${editedFile}"), content);
	}
}
