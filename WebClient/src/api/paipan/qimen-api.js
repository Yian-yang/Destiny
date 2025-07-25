import request from '@/utils/request'

/**
 * 开始排盘
 * 
 * @param data 构造条件
 * @returns    奇门遁甲排盘数据
 */
export const paiPanApi = (data) => {
    return request.post('/qiMen/paiPan', data)
}

