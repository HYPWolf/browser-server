package com.platon.browser.dao.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Block extends BlockKey {
    private Long number;

    private String parentHash;

    private String nonce;

    private String miner;

    private String extraData;

    private Integer size;

    private String energonUsed;

    private String energonLimit;

    private String energonAverage;

    private Integer transactionNumber;

    private Date timestamp;

    private String blockReward;

    private Date createTime;

    private Date updateTime;

    private String actualTxCostSum;

    private Long blockVoteAmount;

    private Long blockVoteNumber;

    private Long blockCampaignAmount;

    private String nodeName;

    private String nodeId;

    private String ticketId;

    private Double rewardRatio;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash == null ? null : parentHash.trim();
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce == null ? null : nonce.trim();
    }

    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner == null ? null : miner.trim();
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData == null ? null : extraData.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getEnergonUsed() {
        return energonUsed;
    }

    public void setEnergonUsed(String energonUsed) {
        this.energonUsed = energonUsed == null ? null : energonUsed.trim();
    }

    public String getEnergonLimit() {
        return energonLimit;
    }

    public void setEnergonLimit(String energonLimit) {
        this.energonLimit = energonLimit == null ? null : energonLimit.trim();
    }

    public String getEnergonAverage() {
        return energonAverage;
    }

    public void setEnergonAverage(String energonAverage) {
        this.energonAverage = energonAverage == null ? null : energonAverage.trim();
    }

    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(String blockReward) {
        this.blockReward = blockReward == null ? null : blockReward.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getActualTxCostSum() {
        return actualTxCostSum;
    }

    public void setActualTxCostSum(String actualTxCostSum) {
        this.actualTxCostSum = actualTxCostSum == null ? null : actualTxCostSum.trim();
    }

    public Long getBlockVoteAmount() {
        return blockVoteAmount;
    }

    public void setBlockVoteAmount(Long blockVoteAmount) {
        this.blockVoteAmount = blockVoteAmount;
    }

    public Long getBlockVoteNumber() {
        return blockVoteNumber;
    }

    public void setBlockVoteNumber(Long blockVoteNumber) {
        this.blockVoteNumber = blockVoteNumber;
    }

    public Long getBlockCampaignAmount() {
        return blockCampaignAmount;
    }

    public void setBlockCampaignAmount(Long blockCampaignAmount) {
        this.blockCampaignAmount = blockCampaignAmount;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public Double getRewardRatio() {
        return rewardRatio;
    }

    public void setRewardRatio(Double rewardRatio) {
        this.rewardRatio = rewardRatio;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table block
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        hash("hash", "hash", "VARCHAR", false),
        chainId("chain_id", "chainId", "VARCHAR", false),
        number("number", "number", "BIGINT", true),
        parentHash("parent_hash", "parentHash", "VARCHAR", false),
        nonce("nonce", "nonce", "VARCHAR", false),
        miner("miner", "miner", "VARCHAR", false),
        extraData("extra_data", "extraData", "VARCHAR", false),
        size("size", "size", "INTEGER", true),
        energonUsed("energon_used", "energonUsed", "VARCHAR", false),
        energonLimit("energon_limit", "energonLimit", "VARCHAR", false),
        energonAverage("energon_average", "energonAverage", "VARCHAR", false),
        transactionNumber("transaction_number", "transactionNumber", "INTEGER", false),
        timestamp("timestamp", "timestamp", "TIMESTAMP", true),
        blockReward("block_reward", "blockReward", "VARCHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        actualTxCostSum("actual_tx_cost_sum", "actualTxCostSum", "VARCHAR", false),
        blockVoteAmount("block_vote_amount", "blockVoteAmount", "BIGINT", false),
        blockVoteNumber("block_vote_number", "blockVoteNumber", "BIGINT", false),
        blockCampaignAmount("block_campaign_amount", "blockCampaignAmount", "BIGINT", false),
        nodeName("node_name", "nodeName", "VARCHAR", false),
        nodeId("node_id", "nodeId", "VARCHAR", false),
        ticketId("ticket_id", "ticketId", "VARCHAR", false),
        rewardRatio("reward_ratio", "rewardRatio", "DOUBLE", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
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
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table block
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
         * This method corresponds to the database table block
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