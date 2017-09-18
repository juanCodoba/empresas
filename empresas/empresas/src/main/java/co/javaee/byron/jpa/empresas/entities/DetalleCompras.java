/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.javaee.byron.jpa.empresas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adsi1199561
 */
@Entity
@Table(name = "detalles_compras")

public class DetalleCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_retencion")
    private double valorRetencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_iva")
    private double valorIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_neto_pagar")
    private double valorNetoPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_compra")
    private double valorCompra;
    @JoinColumn(name = "empresas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresasId;

    public DetalleCompras() {
    }

    public DetalleCompras(Integer id) {
        this.id = id;
    }

    public DetalleCompras(Integer id, double valorUnitario, int cantidad, double valorRetencion, double valorIva, double valorNetoPagar, double valorCompra) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
        this.valorRetencion = valorRetencion;
        this.valorIva = valorIva;
        this.valorNetoPagar = valorNetoPagar;
        this.valorCompra = valorCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorRetencion() {
        return valorRetencion;
    }

    public void setValorRetencion(double valorRetencion) {
        this.valorRetencion = valorRetencion;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getValorNetoPagar() {
        return valorNetoPagar;
    }

    public void setValorNetoPagar(double valorNetoPagar) {
        this.valorNetoPagar = valorNetoPagar;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Empresa getEmpresasId() {
        return empresasId;
    }

    public void setEmpresasId(Empresa empresasId) {
        this.empresasId = empresasId;
    }

    
}
