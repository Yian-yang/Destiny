import request from '@/utils/request'

/**
 * 开始排盘
 * 
 * @param data 构造条件
 * @returns    梅花易数排盘数据
 */
export const paiPanApi = (data) => {
    return request.post('/meiHua/paiPan', data)
}

