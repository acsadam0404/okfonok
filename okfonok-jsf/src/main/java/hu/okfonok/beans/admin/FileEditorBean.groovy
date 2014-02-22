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
@Named("fileEditorBean")
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
		<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:p="http://primefaces.org/ui" xmlns:ui="http://java.sun.com/jsf/facelets" xmlns:okfonok="http://okfonok.hu/facelets" xmlns:sec="http://www.springframework.org/security/tags" xmlns:pe="http://primefaces.org/ui/extensions">
		
		<h:head>
		</h:head>
		
		<h:body>
			<ui:composition>
	"""

	private final String jsfSuffix = """
			</ui:composition>
		</h:body>
		</html>
	"""

}
