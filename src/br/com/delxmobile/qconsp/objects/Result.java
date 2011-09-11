package br.com.delxmobile.qconsp.objects;

import java.util.Map;

public class Result {

	private String created_at;
	private String profile_image_url;
	private String from_user_id_str;
	private String id_str;
	private String from_user;
	private String text;
	private String to_user_id;
	private Map<String, String> metadata;
	private String id;
//	private Map<String, String> geo;
	private String from_user_id;
	private String iso_language_code;
	private String source;
	private String to_user_id_str;

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String createdAt) {
		created_at = createdAt;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profileImageUrl) {
		profile_image_url = profileImageUrl;
	}

	public String getFrom_user_id_str() {
		return from_user_id_str;
	}

	public void setFrom_user_id_str(String fromUserIdStr) {
		from_user_id_str = fromUserIdStr;
	}

	public String getId_str() {
		return id_str;
	}

	public void setId_str(String idStr) {
		id_str = idStr;
	}

	public String getFrom_user() {
		return from_user;
	}

	public void setFrom_user(String fromUser) {
		from_user = fromUser;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(String toUserId) {
		to_user_id = toUserId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
//
//	public Map<String, String> getGeo() {
//		return geo;
//	}
//
//	public void setGeo(Map<String, String> geo) {
//		this.geo = geo;
//	}

	public String getFrom_user_id() {
		return from_user_id;
	}

	public void setFrom_user_id(String fromUserId) {
		from_user_id = fromUserId;
	}

	public String getIso_language_code() {
		return iso_language_code;
	}

	public void setIso_language_code(String isoLanguageCode) {
		iso_language_code = isoLanguageCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTo_user_id_str() {
		return to_user_id_str;
	}

	public void setTo_user_id_str(String toUserIdStr) {
		to_user_id_str = toUserIdStr;
	}

}
