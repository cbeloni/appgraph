package com.appgraph.view;

import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.appgraph.model.Grafico;
import com.appgraph.service.GestaoGrafico;
 
@SuppressWarnings("serial")
@ManagedBean
public class GraficoBean implements Serializable {
 
    private BarChartModel barModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }    
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        GestaoGrafico gg = new GestaoGrafico();
        String nomeGrafico = "BKO_APOIO_7054";
        List<Grafico> linhasGrafico = gg.porNome(nomeGrafico);
        
        ChartSeries serie = new ChartSeries();
        serie.setLabel(nomeGrafico);
        for (Grafico lGrafico : linhasGrafico) {
			System.out.println(lGrafico.getSerie());
			System.out.println(lGrafico.getEixo_y());
			int y = Integer.parseInt(lGrafico.getEixo_y());
			serie.set(lGrafico.getSerie().toString(),y);
		}
        
        /*serie.set("1h", 120);
        serie.set("2h", 100);
        serie.set("3h", 44);
        serie.set("4h", 150);
        serie.set("5h", 25);*/
        
 
        model.addSeries(serie);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Tempo processamento");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Tempo");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(500);
    }
        
 
}