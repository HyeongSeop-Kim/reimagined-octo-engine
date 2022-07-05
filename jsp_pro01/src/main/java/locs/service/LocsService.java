package locs.service;

import java.util.List;

import locs.model.LocsDAO;
import locs.model.LocsDTO;

public class LocsService {
	private LocsDAO dao;
	
	public LocsService() {
		dao = new LocsDAO();
	}
	
	public List<LocsDTO> getAll() {
		List<LocsDTO> datas = dao.searchAll();
		return datas;
	}
	
	public LocsDTO getLocsId(String id) {
		int locsId = Integer.parseInt(id);
		return _getLocsId(locsId);
	}
	
	public LocsDTO getLocsId(int id) {
		return _getLocsId(id);
	}
	
	private LocsDTO _getLocsId(int id) {
		LocsDTO data = dao.searchLocsId(id);
		return data;
	}
}
