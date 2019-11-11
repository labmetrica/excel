package ExcelDownloader.modelo;

import java.time.LocalTime;
import java.util.List;

public class Grupo {

	private Long id;
	private LocalTime nombre;
	private int huecos;
	private List<Usuario> usuarios;

	public Grupo() {
	}

	public Grupo(Long id, LocalTime nombre, int huecos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.huecos = huecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getNombre() {
		return nombre;
	}

	public void setNombre(LocalTime nombre) {
		this.nombre = nombre;
	}

	public int getHuecos() {
		return huecos;
	}

	public void setHuecos(int huecos) {
		this.huecos = huecos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "U [id=" + id + ", nombre=" + nombre + ", huecos=" + huecos + ", usuarios=" + usuarios + "]";
	}
}
