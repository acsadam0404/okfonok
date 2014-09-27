package hu.okfonok.beans;

import hu.okfonok.entities.user.Point
import hu.okfonok.entities.user.User
import hu.okfonok.services.PointService

import org.primefaces.context.RequestContext
import org.primefaces.model.chart.Axis
import org.primefaces.model.chart.AxisType
import org.primefaces.model.chart.CategoryAxis
import org.primefaces.model.chart.ChartSeries
import org.primefaces.model.chart.LineChartModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Feladás 5. - Profil megtekintés
 * https://github.com/acsadam0404/okfonok/issues/56
 */
@Component("userProfileBean")
@Scope("session")
class UserProfileBean {

	User user

	@Autowired
	private PointService pointService
	@Autowired
	private SkillsBean skillsBean
	
	LineChartModel model

	/* XXX nem működik, de ménem? */
	LineChartModel getModel() {
		model = new LineChartModel()

		ChartSeries pointSeries = new ChartSeries()
		pointSeries.setLabel("")
		List<Point> last5 = pointService.findLast5(user)
		last5.each {
			pointSeries.set(it.datum.format("MM.dd"), it.sum)
		}

		model.addSeries(pointSeries)

		model.setShowPointLabels(true)
		Axis yAxis = model.getAxis(AxisType.Y)
		yAxis.setMin(0)

		model.getAxes().put(AxisType.X, new CategoryAxis("Years"));

		return model
	}

	void showDialog(User user) {
		this.user = user
		skillsBean.user = user

		Map options = [
			modal:	true,
			draggable:	false,
			resizable:	false,
			contentWidth: 460,
			contentHeight: 470
		]

		RequestContext.getCurrentInstance().openDialog("fragments/index/profile", options, null)
	}
}
