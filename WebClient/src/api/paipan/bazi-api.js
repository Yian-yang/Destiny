import request from '@/utils/request'

/**
 * 开始排盘
 * 
 * @param data 构造条件
 * @returns    八字排盘数据
 */
export const paiPanApi = (data) => {
    return request.post('/baZi/paiPan', data)
}

/**
 * 大运流年初始化
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const daYunInitializeApi = (data) => {
    return request.post('/baZi/daYunInitialize', data)
}

/**
 * 点击大运
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const daYunApi = (data) => {
    return request.post('/baZi/daYun', data)
}

/**
 * 点击流年
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const liuNianApi = (data) => {
    return request.post('/baZi/liuNian', data)
}

/**
 * 点击流月
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const liuYueApi = (data) => {
    return request.post('/baZi/liuYue', data)
}

/**
 * 点击流日
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const liuRiApi = (data) => {
    return request.post('/baZi/liuRi', data)
}

/**
 * 点击流时
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const liuShiApi = (data) => {
    return request.post('/baZi/liuShi', data)
}


/**
 * 点击胎命身
 * 
 * @param data 构造条件
 * @returns    大运流年数据
 */
export const taiMingShenApi = (data) => {
    return request.post('/baZi/taiMingShen', data)
}
