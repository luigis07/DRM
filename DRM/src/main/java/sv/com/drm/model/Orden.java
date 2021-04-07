/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.drm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "ORDEN")
@SequenceGenerator(allocationSize = 1, name = "SEQ_ORDEN", sequenceName = "SEQ_ORDEN")
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "SEQ_ORDEN", strategy = GenerationType.SEQUENCE)
	@Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    public Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    public BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_TOTAL")
    public BigDecimal montoTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUARIO_CREA")
    public String usuarioCrea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    public Date fechaCrea;
    @JoinColumn(name = "CAT_ESTADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public CatEstado catEstadoId;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Cliente clienteId;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Producto productoId;

    public Orden() {
    }

    public Orden(Long id) {
        this.id = id;
    }

    public Orden(Long id, BigInteger cantidad, BigDecimal montoTotal, String usuarioCrea, Date fechaCrea) {
        this.id = id;
        this.cantidad = cantidad;
        this.montoTotal = montoTotal;
        this.usuarioCrea = usuarioCrea;
        this.fechaCrea = fechaCrea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public CatEstado getCatEstadoId() {
        return catEstadoId;
    }

    public void setCatEstadoId(CatEstado catEstadoId) {
        this.catEstadoId = catEstadoId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Orden[ id=" + id + " ]";
    }
    
}
