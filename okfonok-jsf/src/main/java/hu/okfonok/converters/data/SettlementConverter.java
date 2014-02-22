package hu.okfonok.converters.data;

import hu.okfonok.entities.data.Settlement;
import hu.okfonok.services.data.SettlementService;
import hu.okfonok.utils.ServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;

/**
 * 
 * @author Ács Ádám
 *
 */
@Named("settlementConverter")
@Scope("singleton")
public class SettlementConverter implements Converter {
	private SettlementService service;

	public SettlementService getService() {
		if (service == null) {
			service = ServiceLocator.getBean(SettlementService.class);
		}
		return service;
	}

	@Override
	public Settlement getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}

		return getService().findBySettlement(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null || !(value instanceof Settlement)) {
			return "";
		}
		Settlement Settlement = (Settlement) value;
		return String.valueOf(Settlement.getSettlement());
	}
}
