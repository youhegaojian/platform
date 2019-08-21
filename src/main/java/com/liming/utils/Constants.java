package com.liming.utils;

public class Constants {

    // 语言
    public static enum LANGUAGE {EN, CN};
    // 分析指标
    public static enum INDICATOR {TFIDF, TEXTRANK}

    // 中文 NLP 配置文件
    public static final String CN_NLP_CONFIG = "CoreNLP-chinese.properties";
    // 英文 NLP 配置文件
    public static final String EN_NLP_CONFIG = "CoreNLP-english.properties";
    // 停用词文件
    public static final String STOPWORDS = "dstopwords";
    
    public static final String CN_REGULAR = "(?:[\\u4E00-\\u9FA5]+)";
	public static final String EN_REGULAR = "(?:[\\w]+[-]*[\\w]*)";
    
    public static final String LETTER_REGULAR = "[a-zA-Z]";
    public static final String HTML_REGULAR = "<\\/?[^>]*>|\\&[0-9a-zA-Z]{1,10};";
    public static final String SPECIAL_REGULAR = "\\\\u[0-9a-zA-Z]{4}";

    /*
     en:
     NN 单数名词, NNS 复数名词, NNP 单数专有名词, NNPS 复数专有名词
     JJ 形容词, JJR 形容词比较级, JJS 形容词最高级
     VB 动词, VBD 动词过去时, VBG 动词进行时, VBN 动词完成时, VBP 非第三人称动词, VBZ 第三人称单数动词
     cn:
     NN 普通名词, NR 专有名词, NT 时间名词
     JJ 形容词
     VA 谓词形容词, VE , VV 普通动词
     "jj([rs]?)|v([bdgnpzaev]?)|n([nsprt]?)"
     */
    public static final String WORD_REGULAR = "jj([rs]?)|v([pz]?)|n([nspr]?)";
    public static final String NOTLAST_REGULAR= "jj([rs]?)|v([bgpz]?)";

}
