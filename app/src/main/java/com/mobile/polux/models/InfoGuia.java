package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 19/1/2019.
 */

public class InfoGuia extends RealmObject {

    @PrimaryKey
    private long codigoGuiasCobro;
    @Expose
    private String usuarioIngreso;
    @Expose
    private Integer codigoEmpresa;
    @Expose
    private Integer codigoSucursal;
    //@Expose
    private Integer codigoVendedor;
    @Expose
    private Integer codigoPersonal;
    @Expose
    private String nombreCompletoVendedor;
    @Expose
    private String fechaIngreso;
    @Expose
    private long codigo;

    private RealmList<CashingGuideDetail> details;

    public long getCodigoGuiasCobro() {
        return codigoGuiasCobro;
    }

    public void setCodigoGuiasCobro(long codigoGuiasCobro) {
        this.codigoGuiasCobro = codigoGuiasCobro;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Integer codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Integer getCodigoPersonal() {
        return codigoPersonal;
    }

    public void setCodigoPersonal(Integer codigoPersonal) {
        this.codigoPersonal = codigoPersonal;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public RealmList<CashingGuideDetail> getDetails() {
        if (details == null)
            return new RealmList<>();
        return details;
    }

    public void setDetails(RealmList<CashingGuideDetail> details) {
        this.details = details;
    }

    public String getNombreCompletoVendedor() {
        return nombreCompletoVendedor;
    }

    public void setNombreCompletoVendedor(String nombreCompletoVendedor) {
        this.nombreCompletoVendedor = nombreCompletoVendedor;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public InfoGuia toUnManaged(Realm realm) {
        return isManaged() ? realm.copyFromRealm(this) : this;
    }
}
