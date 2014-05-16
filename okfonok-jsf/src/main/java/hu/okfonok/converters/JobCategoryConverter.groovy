package hu.okfonok.converters

import hu.okfonok.entities.JobCategory
import hu.okfonok.services.JobCategoryService
import hu.okfonok.utils.ServiceLocator

import javax.faces.component.UIComponent
import javax.faces.context.FacesContext
import javax.faces.convert.Converter
import javax.inject.Named

import org.apache.commons.lang3.StringUtils
import org.springframework.context.annotation.Scope

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("jobCategoryConverter")
@Scope("singleton")
class JobCategoryConverter implements Converter {
	private JobCategoryService service;

	public JobCategoryService getService() {
		if (service == null) {
			service = ServiceLocator.getBean(JobCategoryService.class);
		}
		return service;
	}

	@Override
	public JobCategory getAsObject(FacesContext context, UIComponent component, String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		return getService().findByName(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,	Object value) {
		if (value == null || !(value instanceof JobCategory)) {
			return "";
		}
		JobCategory jc = (JobCategory) value;
		return jc.name;
	}
}
