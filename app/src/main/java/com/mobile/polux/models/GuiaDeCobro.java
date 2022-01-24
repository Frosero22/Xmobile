package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 26/11/2018.
 */

public class GuiaDeCobro {

    @SerializedName("guiaDeCobro")
    private InfoGuia guiaDeCobro;
    /*@SerializedName("codigoGuiasCobro")
    private Integer codigoGuiasCobro;
    @SerializedName("codigoSucursal")
    private Integer codigoSucursal;
    @SerializedName("nombreSucursal")
    private String nombreSucursal;
    @SerializedName("codigoVendedor")
    private Integer codigoVendedor;
    @SerializedName("nombreVendedor")
    private String nombreVendedor;*/
    @SerializedName("detalleCobros")
    private List<DetalleCobro> detalleCobros;
    //@SerializedName("comprobantesDeCobroPorCliente")
   // private List<DetalleCobro> comprobantesCobroCliente;


    public InfoGuia getGuiaDeCobro() {
        return guiaDeCobro;
    }

    public void setGuiaDeCobro(InfoGuia guiaDeCobro) {
        this.guiaDeCobro = guiaDeCobro;
    }

    public List<DetalleCobro> getDetalleCobros() {
        return detalleCobros;
    }

    public void setDetalleCobros(List<DetalleCobro> detalleCobros) {
        this.detalleCobros = detalleCobros;
    }
}