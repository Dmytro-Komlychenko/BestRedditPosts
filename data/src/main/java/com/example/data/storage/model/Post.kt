package com.example.data.storage.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("created_utc")
    @Expose
    var createdUNIX: Long,

    @SerializedName("author")
    @Expose
    var authorName: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("thumbnail") // in child - fallback_url (video)
    @Expose
    var thumbnail: String?,

    @SerializedName("thumbnail_width")
    @Expose
    var thumbnailWidth: Int?,

    @SerializedName("thumbnail_height")
    @Expose
    var thumbnailHeight: Int?,

    @SerializedName("ups")
    @Expose
    var likesCount: Int,

    @SerializedName("num_comments")
    @Expose
    var commentsCount: Int,
)

/*@SerializedName("subreddit")
@Expose
var subreddit: String? = null

@SerializedName("selftext")
@Expose
var selftext: String? = null



@SerializedName("saved")
@Expose
var saved: Boolean? = null

@SerializedName("mod_reason_title")
@Expose
var modReasonTitle: Any? = null

@SerializedName("gilded")
@Expose
var gilded: Int? = null

@SerializedName("clicked")
@Expose
var clicked: Boolean? = null

@SerializedName("title")
@Expose
var title: String? = null

@SerializedName("link_flair_richtext")
@Expose
var linkFlairRichtext: List<Any>? = null

@SerializedName("subreddit_name_prefixed")
@Expose
var subredditNamePrefixed: String? = null

@SerializedName("hidden")
@Expose
var hidden: Boolean? = null

@SerializedName("pwls")
@Expose
var pwls: Int? = null

@SerializedName("link_flair_css_class")
@Expose
var linkFlairCssClass: Any? = null

@SerializedName("downs")
@Expose
var downs: Int? = null

@SerializedName("thumbnail_height")
@Expose
var thumbnailHeight: Int? = null

@SerializedName("top_awarded_type")
@Expose
var topAwardedType: Any? = null

@SerializedName("hide_score")
@Expose
var hideScore: Boolean? = null

@SerializedName("name")
@Expose
var name: String? = null

@SerializedName("quarantine")
@Expose
var quarantine: Boolean? = null

@SerializedName("link_flair_text_color")
@Expose
var linkFlairTextColor: String? = null

@SerializedName("upvote_ratio")
@Expose
var upvoteRatio: Float? = null

@SerializedName("author_flair_background_color")
@Expose
var authorFlairBackgroundColor: Any? = null

@SerializedName("subreddit_type")
@Expose
var subredditType: String? = null

@SerializedName("ups")
@Expose
var ups: Int? = null

@SerializedName("total_awards_received")
@Expose
var totalAwardsReceived: Int? = null

@SerializedName("media_embed")
@Expose
var mediaEmbed: MediaEmbed? = null

@SerializedName("thumbnail_width")
@Expose
var thumbnailWidth: Int? = null

@SerializedName("author_flair_template_id")
@Expose
var authorFlairTemplateId: Any? = null

@SerializedName("is_original_content")
@Expose
var isOriginalContent: Boolean? = null

@SerializedName("user_reports")
@Expose
var userReports: List<Any>? = null

@SerializedName("secure_media")
@Expose
var secureMedia: SecureMedia? = null

@SerializedName("is_reddit_media_domain")
@Expose
var isRedditMediaDomain: Boolean? = null

@SerializedName("is_meta")
@Expose
var isMeta: Boolean? = null

@SerializedName("category")
@Expose
var category: Any? = null

@SerializedName("secure_media_embed")
@Expose
var secureMediaEmbed: SecureMediaEmbed? = null

@SerializedName("link_flair_text")
@Expose
var linkFlairText: Any? = null

@SerializedName("can_mod_post")
@Expose
var canModPost: Boolean? = null

@SerializedName("score")
@Expose
var score: Int? = null

@SerializedName("approved_by")
@Expose
var approvedBy: Any? = null

@SerializedName("is_created_from_ads_ui")
@Expose
var isCreatedFromAdsUi: Boolean? = null

@SerializedName("author_premium")
@Expose
var authorPremium: Boolean? = null



@SerializedName("edited")
@Expose
var edited: Boolean? = null

@SerializedName("author_flair_css_class")
@Expose
var authorFlairCssClass: Any? = null

@SerializedName("author_flair_richtext")
@Expose
var authorFlairRichtext: List<Any>? = null

@SerializedName("gildings")
@Expose
var gildings: Gildings? = null

@SerializedName("post_hint")
@Expose
var postHint: String? = null

@SerializedName("content_categories")
@Expose
var contentCategories: Any? = null

@SerializedName("is_self")
@Expose
var isSelf: Boolean? = null

@SerializedName("mod_note")
@Expose
var modNote: Any? = null

@SerializedName("created")
@Expose
var created: Float? = null

@SerializedName("link_flair_type")
@Expose
var linkFlairType: String? = null

@SerializedName("wls")
@Expose
var wls: Int? = null

@SerializedName("removed_by_category")
@Expose
var removedByCategory: Any? = null

@SerializedName("banned_by")
@Expose
var bannedBy: Any? = null

@SerializedName("author_flair_type")
@Expose
var authorFlairType: String? = null

@SerializedName("domain")
@Expose
var domain: String? = null

@SerializedName("allow_live_comments")
@Expose
var allowLiveComments: Boolean? = null

@SerializedName("selftext_html")
@Expose
var selftextHtml: Any? = null

@SerializedName("likes")
@Expose
var likes: Any? = null

@SerializedName("suggested_sort")
@Expose
var suggestedSort: Any? = null

@SerializedName("banned_at_utc")
@Expose
var bannedAtUtc: Any? = null

@SerializedName("url_overridden_by_dest")
@Expose
var urlOverriddenByDest: String? = null

@SerializedName("view_count")
@Expose
var viewCount: Any? = null

@SerializedName("archived")
@Expose
var archived: Boolean? = null

@SerializedName("no_follow")
@Expose
var noFollow: Boolean? = null

@SerializedName("is_crosspostable")
@Expose
var isCrosspostable: Boolean? = null

@SerializedName("pinned")
@Expose
var pinned: Boolean? = null

@SerializedName("over_18")
@Expose
var over18: Boolean? = null

@SerializedName("preview")
@Expose
var preview: com.sun.tools.javac.code.Preview? = null

@SerializedName("all_awardings")
@Expose
var allAwardings: List<AllAwarding>? = null
}*/