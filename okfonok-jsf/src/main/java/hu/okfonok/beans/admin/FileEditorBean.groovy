package hu.okfonok.beans.admin

import hu.okfonok.utils.Config;

import javax.inject.Named

import org.apache.commons.io.FileUtils
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@org.springframework.stereotype.Component("fileEditorBean")
@Scope("view")
class FileEditorBean implements Serializable {
	String content
	String editedFile

	void saveListener() {
		String jsfContent = jsfPrefix + content + jsfSuffix
		FileUtils.write(new File("${Config.staticContextPath}/${editedFile}"), jsfContent.trim());
	}
	
	private final String jsfPrefix = """
		<?xml version='1.0' encoding='UTF-8' ?>
		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
		<html xmlns="http://www.w3.org/1999/xhtml">
		
		<head>
		</head>
		
		<body onload="parent.alertsize(document.body.scrollHeight);">
	"""

	private final String jsfSuffix = """
		</body>
		</html>
	"""

}
