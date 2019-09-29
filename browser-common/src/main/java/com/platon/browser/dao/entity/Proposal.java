package com.platon.browser.dao.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Proposal {
    private String hash;

    private String type;

    private String verifier;

    private String verifierName;

    private String url;

    private String newVersion;

    private String endVotingBlock;

    private String activeBlock;

    private Date timestamp;

    private Long yeas;

    private Long nays;

    private Long abstentions;

    private Long accuVerifiers;

    private Integer status;

    private Date updateTime;

    private Date createTime;

    private String pipNum;

    private String pipId;

    private String topic;

    private String description;

    private String canceledPipId;

    private String canceledTopic;

    private String blockNumber;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier == null ? null : verifier.trim();
    }

    public String getVerifierName() {
        return verifierName;
    }

    public void setVerifierName(String verifierName) {
        this.verifierName = verifierName == null ? null : verifierName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion == null ? null : newVersion.trim();
    }

    public String getEndVotingBlock() {
        return endVotingBlock;
    }

    public void setEndVotingBlock(String endVotingBlock) {
        this.endVotingBlock = endVotingBlock == null ? null : endVotingBlock.trim();
    }

    public String getActiveBlock() {
        return activeBlock;
    }

    public void setActiveBlock(String activeBlock) {
        this.activeBlock = activeBlock == null ? null : activeBlock.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getYeas() {
        return yeas;
    }

    public void setYeas(Long yeas) {
        this.yeas = yeas;
    }

    public Long getNays() {
        return nays;
    }

    public void setNays(Long nays) {
        this.nays = nays;
    }

    public Long getAbstentions() {
        return abstentions;
    }

    public void setAbstentions(Long abstentions) {
        this.abstentions = abstentions;
    }

    public Long getAccuVerifiers() {
        return accuVerifiers;
    }

    public void setAccuVerifiers(Long accuVerifiers) {
        this.accuVerifiers = accuVerifiers;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPipNum() {
        return pipNum;
    }

    public void setPipNum(String pipNum) {
        this.pipNum = pipNum == null ? null : pipNum.trim();
    }

    public String getPipId() {
        return pipId;
    }

    public void setPipId(String pipId) {
        this.pipId = pipId == null ? null : pipId.trim();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCanceledPipId() {
        return canceledPipId;
    }

    public void setCanceledPipId(String canceledPipId) {
        this.canceledPipId = canceledPipId == null ? null : canceledPipId.trim();
    }

    public String getCanceledTopic() {
        return canceledTopic;
    }

    public void setCanceledTopic(String canceledTopic) {
        this.canceledTopic = canceledTopic == null ? null : canceledTopic.trim();
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber == null ? null : blockNumber.trim();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table proposal
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        hash("hash", "hash", "VARCHAR", false),
        type("type", "type", "VARCHAR", true),
        verifier("verifier", "verifier", "VARCHAR", false),
        verifierName("verifier_name", "verifierName", "VARCHAR", false),
        url("url", "url", "VARCHAR", false),
        newVersion("new_version", "newVersion", "VARCHAR", false),
        endVotingBlock("end_voting_block", "endVotingBlock", "VARCHAR", false),
        activeBlock("active_block", "activeBlock", "VARCHAR", false),
        timestamp("timestamp", "timestamp", "TIMESTAMP", true),
        yeas("yeas", "yeas", "BIGINT", false),
        nays("nays", "nays", "BIGINT", false),
        abstentions("abstentions", "abstentions", "BIGINT", false),
        accuVerifiers("accu_verifiers", "accuVerifiers", "BIGINT", false),
        status("status", "status", "INTEGER", true),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        pipNum("pip_num", "pipNum", "VARCHAR", false),
        pipId("pip_id", "pipId", "VARCHAR", false),
        topic("topic", "topic", "VARCHAR", false),
        description("description", "description", "VARCHAR", false),
        canceledPipId("canceled_pip_id", "canceledPipId", "VARCHAR", false),
        canceledTopic("canceled_topic", "canceledTopic", "VARCHAR", false),
        blockNumber("block_number", "blockNumber", "VARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table proposal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}