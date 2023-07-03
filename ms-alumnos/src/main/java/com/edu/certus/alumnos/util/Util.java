package com.edu.certus.alumnos.util;

import com.edu.certus.alumnos.dto.ResponseDto;
import com.edu.certus.alumnos.util.Constante;

public class Util {

	public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
		ResponseDto response = new ResponseDto();
		String cod = (!success) ? Constante.CODE_FAILED : Constante.CODE_SUCCES;
		response.setCodigo(cod);
		response.setMensaje(mensaje);
		response.setData(data);
		return response;
	}
}
