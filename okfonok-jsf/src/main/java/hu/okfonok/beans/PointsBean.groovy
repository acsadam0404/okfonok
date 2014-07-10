package hu.okfonok.beans

import hu.okfonok.entities.user.Point
import hu.okfonok.services.PointService

import org.primefaces.model.chart.Axis
import org.primefaces.model.chart.AxisType
import org.primefaces.model.chart.CategoryAxis
import org.primefaces.model.chart.ChartSeries
import org.primefaces.model.chart.LineChartModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("pointsBean")
@Scope("session")
class PointsBean {
	@Autowired
	private PointService pointService
	
	LineChartModel model
	
	LineChartModel getModel() {
		if (model == null) {
			model = new LineChartModel()
		
			ChartSeries pointSeries = new ChartSeries()
			pointSeries.setLabel("")
			List<Point> last5 = pointService.findLast5()
			last5.each { 
				pointSeries.set(it.datum.format("MM.dd"), it.sum)
			}
		
			model.addSeries(pointSeries)
		
			model.setShowPointLabels(true)
			Axis yAxis = model.getAxis(AxisType.Y)
			yAxis.setMin(0)
			
			model.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		}

		return model
	}
}
