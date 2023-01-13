package models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;
    private String cliente;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto;

    public Pedido() {
        Date fecha = new Date(System.currentTimeMillis());
        this.fecha = fecha;
        this.estado = "Pendiente";
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente='" + cliente + '\'' +
                ", estado='" + estado + '\'' +
                ", producto=" + producto.getNombre() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}