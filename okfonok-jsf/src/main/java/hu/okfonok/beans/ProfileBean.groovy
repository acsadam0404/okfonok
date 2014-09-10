package hu.okfonok.beans

import hu.okfonok.services.UserService
import hu.okfonok.utils.Config

import javax.annotation.PostConstruct
import javax.faces.context.FacesContext
import javax.servlet.ServletContext

import org.apache.commons.io.FileUtils
import org.primefaces.context.RequestContext
import org.primefaces.event.FileUploadEvent
import org.primefaces.model.CroppedImage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope


@org.springframework.stereotype.Component("profileBean")
@Scope("session")
class ProfileBean implements Serializable{
	@Autowired
	private UserService userService
	@Autowired
	private UserBean userBean

	CroppedImage croppedImage
	String imagePath

	@PostConstruct
	private void init() {
		imagePath = "tmp/${userBean.user.userName}/profile.jpg"
	}

	void profilePictureUpload(FileUploadEvent event) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()
		FileUtils.writeByteArrayToFile(new File("${servletContext.getRealPath('')}/${imagePath}"), event.file.contents)
	}

	void openProfileCropperDialog() {
		Map options = [
			modal:	true,
			draggable:	false,
			resizable:	false,
			contentHeight: 320
		]

		RequestContext.getCurrentInstance().openDialog("fragments/index/profileCropperDialog", options, null)
	}

	public void crop() {
		if(croppedImage == null) {
			return;
		}

		String newFileName = "${userBean.user.userName}/profile.jpg"
		FileUtils.writeByteArrayToFile(new File(Config.userProfilePath + '/' + newFileName), croppedImage.bytes)
		userBean.user.profile.profileImagePath = "users/${newFileName}"
		RequestContext.getCurrentInstance().closeDialog()
	}
}
