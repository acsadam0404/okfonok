package hu.okfonok.beans

import hu.okfonok.services.UserService
import hu.okfonok.utils.Config

import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import javax.imageio.stream.FileImageOutputStream
import javax.servlet.ServletContext

import org.apache.commons.io.FileUtils
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

	void profilePictureUpload(FileUploadEvent event) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()
		imagePath = "tmp/${userBean.user.userName}/profile"
		FileUtils.writeByteArrayToFile(new File("${servletContext.getRealPath('')}/${imagePath}"), event.file.contents)
	}

	void profilePictureCropped() {

		userBean.user = userService.save(userBean.user)
	}
	
	public void crop() {
		if(croppedImage == null) {
			return;
		}
		 
		String newFileName = "${Config.userProfilePath}/${userBean.user.userName}/profile"
		FileUtils.writeByteArrayToFile(new File(newFileName), croppedImage.bytes)
		userBean.user.profile.profileImagePath = newFileName
	}
}
