/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.turbotax.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Christian
 */
@Entity
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rucCliente;
    private String razonSocialCliente;
    private String numero;

    private String rucProveedor;
    private String razonSocialProveedor;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String periodo;
    @Enumerated(EnumType.STRING)
    private Libro tipoFactura;
    @Enumerated(EnumType.STRING)
    private TipoImpuesto tipoImpuesto;
    private String clasificacion;
    private boolean conIRP;
    private boolean conIRPC;
    private String tipoIngreso;
    private String tipoGasto;
    private String tipoInversion;
    private String subTipoIngreso;
    private String subTipoGasto;
    private String subTipoInversion;
    private String tipoExportacion;
    private String tipoAjustes;

    private BigDecimal gravada05 = new BigDecimal(BigInteger.ZERO);
    private BigDecimal gravada10 = new BigDecimal(BigInteger.ZERO);
    private BigDecimal exento = new BigDecimal(BigInteger.ZERO);
    private BigDecimal iva05 = new BigDecimal(BigInteger.ZERO);
    private BigDecimal iva10 = new BigDecimal(BigInteger.ZERO);
    private BigDecimal gravada05Neto = new BigDecimal(BigInteger.ZERO);
    private BigDecimal gravada10Neto = new BigDecimal(BigInteger.ZERO);

    private BigDecimal totalIva = new BigDecimal(BigInteger.ZERO);
    private BigDecimal totalNeto = new BigDecimal(BigInteger.ZERO);
    private BigDecimal totalBruto = new BigDecimal(BigInteger.ZERO);
    @Transient
    private boolean cambiaPeriodo;
    private String url;
    private String periodoAnio;
    private String periodoMes;
    private Integer plazoAnios;

    @Column(name = "subclasificacion")
    private String subclasificacion;
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Column(name = "exportaciones")
    private BigInteger exportaciones;
    @Column(name = "nogravadoyexonerado")
    private BigInteger nogravadoyexonerado;
    @Column(name = "montopagado")
    private BigInteger montopagado;
    @Column(name = "gravados")
    private BigInteger gravados;
    @Column(name = "inscriptoeniva")
    private String inscriptoeniva;
    @Column(name = "nrotimbrado")
    private Integer nrotimbrado;
    @Column(name = "provienebienesgananciales")
    private Boolean provienebienesgananciales = false;

    @Transient
    private String fechaString;

    public String getFechaString() {
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "py"));
            fechaString = sdf.format(fecha);

        }
        return fechaString;
    }

    public Integer getPlazoAnios() {
        return plazoAnios;
    }

    public void setPlazoAnios(Integer plazoAnios) {
        this.plazoAnios = plazoAnios;
    }

    public String getPeriodoMes() {
        return periodoMes;
    }

    public void setPeriodoMes(String periodoMes) {
        this.periodoMes = periodoMes;
    }

    public String getPeriodoAnio() {
        return periodoAnio;
    }

    public void setPeriodoAnio(String periodoAnio) {

        this.periodoAnio = periodoAnio;
    }

    public boolean isCambiaPeriodo() {
        return cambiaPeriodo;
    }

    public void setCambiaPeriodo(boolean cambiaPeriodo) {
        this.cambiaPeriodo = cambiaPeriodo;
    }

    public boolean isConIRPC() {
        return conIRPC;
    }

    public void setConIRPC(boolean conIRPC) {
        this.conIRPC = conIRPC;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isConIRP() {
        return conIRP;
    }

    public void setConIRP(boolean conIRP) {
        this.conIRP = conIRP;
    }

    public String getTipoExportacion() {
        return tipoExportacion;
    }

    public void setTipoExportacion(String tipoExportacion) {
        this.tipoExportacion = tipoExportacion;
    }

    public String getTipoAjustes() {
        return tipoAjustes;
    }

    public void setTipoAjustes(String tipoAjustes) {
        this.tipoAjustes = tipoAjustes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getRazonSocialCliente() {
        return razonSocialCliente;
    }

    public void setRazonSocialCliente(String razonSocialCliente) {
        this.razonSocialCliente = razonSocialCliente;
    }

    public String getRucProveedor() {
        return rucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        this.rucProveedor = rucProveedor;
    }

    public String getRazonSocialProveedor() {
        return razonSocialProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        this.razonSocialProveedor = razonSocialProveedor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        if (fecha != null) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(fecha);
            setPeriodoAnio(gc.get(Calendar.YEAR) + "");
        }

        this.fecha = fecha;
    }

    public String getPeriodo() {
        if (getPeriodoMes() != null && getPeriodoAnio() != null) {
            periodo = getPeriodoMes() + "-" + getPeriodoAnio();
        } else if (getPeriodoMes() == null && getPeriodoAnio() != null) {
            periodo = getPeriodoAnio();
        } else if (getPeriodoMes() != null && getPeriodoAnio() == null) {
            periodo = getPeriodoMes();
        }

        return periodo;
    }

    public void setPeriodo(String periodo) {
        if (getPeriodoMes() != null && getPeriodoAnio() != null) {
            periodo = getPeriodoMes() + "-" + getPeriodoAnio();
        } else if (getPeriodoMes() == null && getPeriodoAnio() != null) {
            periodo = getPeriodoAnio();
        } else if (getPeriodoMes() != null && getPeriodoAnio() == null) {
            periodo = getPeriodoMes();
        }
        this.periodo = periodo;
    }

    public Libro getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(Libro tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public String getTipoInversion() {
        return tipoInversion;
    }

    public void setTipoInversion(String tipoInversion) {
        this.tipoInversion = tipoInversion;
    }

    public String getSubTipoIngreso() {
        return subTipoIngreso;
    }

    public void setSubTipoIngreso(String subTipoIngreso) {
        this.subTipoIngreso = subTipoIngreso;
    }

    public String getSubTipoGasto() {
        return subTipoGasto;
    }

    public void setSubTipoGasto(String subTipoGasto) {
        this.subTipoGasto = subTipoGasto;
    }

    public String getSubTipoInversion() {
        return subTipoInversion;
    }

    public void setSubTipoInversion(String subTipoInversion) {
        this.subTipoInversion = subTipoInversion;
    }

    public BigDecimal getGravada05Neto() {
        gravada05Neto = getGravada05().subtract(getIva05());
        return gravada05Neto;
    }

    public void setGravada05Neto(BigDecimal gravada05Neto) {
        this.gravada05Neto = gravada05Neto;
    }

    public BigDecimal getGravada10Neto() {
        gravada10Neto = getGravada10().subtract(getIva10());
        return gravada10Neto;
    }

    public void setGravada10Neto(BigDecimal gravada10Neto) {
        this.gravada10Neto = gravada10Neto;
    }

    public BigDecimal getTotalIva() {
        if (totalIva == null || totalIva.compareTo(BigDecimal.ZERO) == 0) {
            if (tipoImpuesto == TipoImpuesto.IVA_SIMPLIFICADO) {

                totalIva = totalBruto.multiply(new BigDecimal(0.073));
            } else if (tipoImpuesto == TipoImpuesto.IRP && totalIva == null) {
                totalIva = BigDecimal.ZERO;
            } else {
                totalIva = getIva05().add(getIva10());
            }
        }
        return totalIva;
    }

    public void setTotalIva(BigDecimal totalIva) {
        this.totalIva = totalIva;
    }

    public BigDecimal getTotalNeto() {
        totalNeto = getTotalBruto().subtract(getTotalIva());
        return totalNeto;
    }

    public void setTotalNeto(BigDecimal totalNeto) {
        this.totalNeto = totalNeto;
    }

    public BigDecimal getTotalBruto() {
        if (tipoImpuesto != TipoImpuesto.IVA_SIMPLIFICADO && tipoImpuesto != TipoImpuesto.IRP) {
            totalBruto = getExento().add(getGravada05()).add(getGravada10());
        }

        return totalBruto;
    }

    public void setTotalBruto(BigDecimal totalBruto) {
        this.totalBruto = totalBruto;
    }

    public BigDecimal getGravada05() {
        return gravada05;
    }

    public void setGravada05(BigDecimal gravada05) {
        this.gravada05 = gravada05;
    }

    public BigDecimal getGravada10() {
        return gravada10;
    }

    public void setGravada10(BigDecimal gravada10) {
        this.gravada10 = gravada10;
    }

    public BigDecimal getExento() {
        return exento;
    }

    public void setExento(BigDecimal exento) {
        this.exento = exento;
    }

    public BigDecimal getIva05() {
        iva05 = getGravada05().divide(new BigDecimal(21), 0, RoundingMode.HALF_EVEN);
        return iva05;
    }

    public void setIva05(BigDecimal iva05) {
        this.iva05 = iva05;
    }

    public BigDecimal getIva10() {
        iva10 = getGravada10().divide(new BigDecimal(11), 0, RoundingMode.HALF_EVEN);
        return iva10;
    }

    public String getSubclasificacion() {
        return subclasificacion;
    }

    public void setSubclasificacion(String subclasificacion) {
        this.subclasificacion = subclasificacion;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public BigInteger getExportaciones() {
        return exportaciones;
    }

    public void setExportaciones(BigInteger exportaciones) {
        this.exportaciones = exportaciones;
    }

    public BigInteger getNogravadoyexonerado() {
        if (tipoImpuesto == TipoImpuesto.IRP && provienebienesgananciales) {
            nogravadoyexonerado = getTotalBruto().multiply(new BigDecimal(0.5)).toBigInteger();
        } else if (tipoImpuesto == TipoImpuesto.IRP) {
            nogravadoyexonerado = getTotalBruto().subtract(new BigDecimal(getGravados().doubleValue())).toBigInteger();
        }
        return nogravadoyexonerado;
    }

    public void setNogravadoyexonerado(BigInteger nogravadoyexonerado) {
        this.nogravadoyexonerado = nogravadoyexonerado;
    }

    public BigInteger getGravados() {
        if (provienebienesgananciales) {
            gravados = getTotalBruto().multiply(new BigDecimal(0.5)).toBigInteger();
        } else if (tipoImpuesto == TipoImpuesto.IRP) {
            gravados = getTotalBruto().toBigInteger();
        }
        return gravados;
    }

    public void setGravados(BigInteger gravados) {
        this.gravados = gravados;
    }

    public String getInscriptoeniva() {
        return inscriptoeniva;
    }

    public void setInscriptoeniva(String inscriptoeniva) {
        this.inscriptoeniva = inscriptoeniva;
    }

    public Integer getNrotimbrado() {
        return nrotimbrado;
    }

    public void setNrotimbrado(Integer nrotimbrado) {
        this.nrotimbrado = nrotimbrado;
    }

    public Boolean getProvienebienesgananciales() {
        return provienebienesgananciales;
    }

    public void setProvienebienesgananciales(Boolean provienebienesgananciales) {
        this.provienebienesgananciales = provienebienesgananciales;
    }

    public BigInteger getMontopagado() {
        if (tipoImpuesto == TipoImpuesto.IRP && tipodocumento != null && tipodocumento.compareTo("FACTURA CREDITO") == 0) {
            montopagado = new BigInteger("0");
        } else {
            montopagado = getTotalBruto().toBigInteger();
        }
        return montopagado;
    }

    public void setMontopagado(BigInteger montopagado) {
        this.montopagado = montopagado;
    }

    public void setIva10(BigDecimal iva10) {
        this.iva10 = iva10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ideaspymes.contax.modelo.Factura[ id=" + id + " ]";
    }

    public boolean isAplicaIva() {
        boolean R = false;
        if (tipodocumento != null && (tipodocumento.compareTo("TICKET") == 0
                || tipodocumento.compareTo("FACTURA CONTADO") == 0
                || tipodocumento.compareTo("FACTURA") == 0
                || tipodocumento.compareTo("FACTURA CREDITO") == 0
                || tipodocumento.compareTo("BOLETA DE VENTA") == 0
                || tipodocumento.compareTo("ESCRITURA PÚBLICA") == 0)) {

            R = true;
        }
        return R;
    }

}
