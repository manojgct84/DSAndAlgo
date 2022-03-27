package com.scaler.dc.advance.TwoPointer.homework;

public class Array3Pointers {

    public static void main(String[] args) {
        System.out.println(minimize(new int[]{1, 4, 10}, new int[]{2, 15, 20}, new int[]{10, 12}));
        System.out.println(minimize(new int[]{3, 5, 6}, new int[]{2}, new int[]{3, 4}));
        System.out.println(minimize(new int[]{1}, new int[]{1}, new int[]{1}));
        System.out.println(minimize(new int[]{8, 49, 57, 120, 140, 160, 248, 353, 452, 462, 680, 695, 708, 739, 811, 837, 918, 938, 971, 990, 1027, 1050, 1075, 1096, 1104, 1114, 1184, 1252, 1292, 1302, 1320, 1337, 1389, 1392, 1513, 1560, 1619, 1731, 1813, 1880, 1881, 1885, 1896, 1990, 2059, 2075, 2121, 2228, 2271, 2271, 2396, 2410, 2411, 2492, 2493, 2553, 2563, 2663, 2727, 2793, 2983, 2984, 3097, 3136, 3232, 3270, 3824, 3883, 3891, 3926, 3930, 3943, 4061, 4076, 4203, 4234, 4242, 4273, 4290, 4302, 4316, 4443, 4510, 4728, 4844, 4848, 4902, 4953, 4987, 4998, 5020, 5061, 5109, 5134, 5216, 5310, 5319, 5342, 5424, 5523, 5568, 5574, 5596, 5597, 5682, 5687, 5832, 5881, 5908, 5928, 5984, 6178, 6302, 6352, 6375, 6435, 6556, 6592, 6613, 6644, 6674, 6685, 6742, 6867, 6891, 6923, 6974, 6975, 7023, 7075, 7101, 7131, 7181, 7197, 7321, 7390, 7400, 7449, 7454, 7558, 7658, 7729, 7750, 7760, 7852, 7856, 7873, 7950, 8012, 8125, 8158, 8160, 8202, 8521, 8534, 8590, 8630, 8658, 8689, 8714, 8755, 8765, 8779, 8795, 8837, 8874, 8946, 9082, 9085, 9121, 9148, 9161, 9177, 9301, 9310, 9348, 9366, 9428, 9458, 9474, 9501, 9504, 9586, 9603, 9605, 9663, 9802},
                new int[]{4, 23, 60, 83, 91, 125, 127, 129, 147, 191, 220, 234, 259, 279, 340, 347, 388, 392, 407, 421, 425, 441, 473, 495, 511, 511, 515, 518, 522, 562, 591, 603, 665, 671, 694, 738, 753, 760, 778, 792, 800, 824, 870, 905, 906, 924, 985, 988, 1007, 1034, 1035, 1058, 1073, 1088, 1093, 1096, 1111, 1112, 1144, 1162, 1167, 1171, 1190, 1199, 1210, 1211, 1237, 1237, 1247, 1283, 1340, 1396, 1405, 1422, 1439, 1442, 1443, 1450, 1465, 1472, 1517, 1549, 1555, 1593, 1620, 1623, 1652, 1664, 1668, 1671, 1684, 1730, 1757, 1770, 1780, 1800, 1831, 1837, 1866, 1890, 1891, 1964, 2027, 2040, 2056, 2112, 2144, 2198, 2224, 2246, 2297, 2309, 2337, 2337, 2364, 2417, 2427, 2446, 2461, 2462, 2475, 2501, 2521, 2546, 2625, 2630, 2632, 2638, 2646, 2683, 2716, 2732, 2766, 2781, 2784, 2828, 2840, 2841, 2842, 2862, 2892, 2899, 2930, 2936, 2956, 2978, 2990, 3046, 3057, 3108, 3135, 3138, 3153, 3155, 3219, 3226, 3244, 3270, 3272, 3292, 3336, 3367, 3375, 3380, 3390, 3406, 3414, 3416, 3430, 3436, 3501, 3510, 3519, 3539, 3562, 3573, 3573, 3619, 3642, 3652, 3659, 3664, 3689, 3694, 3709, 3711, 3731, 3736, 3744, 3791, 3813, 3848, 3859, 3872, 3900, 3909, 3924, 3965, 3971, 3980, 3993, 4005, 4029, 4052, 4078, 4101, 4105, 4142, 4154, 4162, 4203, 4208, 4239, 4252, 4274, 4299, 4333, 4336, 4338, 4338, 4354, 4387, 4396, 4434, 4464, 4501, 4516, 4519, 4533, 4534, 4552, 4581, 4582, 4585, 4590, 4599, 4612, 4621, 4627, 4656, 4668, 4669, 4681, 4725, 4760, 4762, 4770, 4798, 4815, 4836, 4837, 4935, 4943, 4946, 4954, 4970, 4978, 4991, 5017, 5037, 5041, 5052, 5054, 5073, 5082, 5112, 5131, 5131, 5155, 5162, 5203, 5234, 5237, 5241, 5251, 5269, 5294, 5297, 5299, 5329, 5332, 5338, 5346, 5419, 5442, 5513, 5568, 5569, 5603, 5621, 5652, 5680, 5689, 5709, 5730, 5739, 5756, 5777, 5783, 5802, 5831, 5876, 5890, 5912, 5918, 5928, 5955, 5970, 5970, 5991, 6061, 6062, 6068, 6086, 6119, 6122, 6123, 6247, 6268, 6340, 6389, 6406, 6417, 6421, 6422, 6444, 6479, 6482, 6500, 6533, 6550, 6553, 6555, 6582, 6597, 6664, 6687, 6705, 6717, 6735, 6763, 6770, 6774, 6791, 6792, 6808, 6811, 6825, 6856, 6863, 6881, 6902, 6907, 6969, 7019, 7024, 7036, 7162, 7163, 7172, 7219, 7219, 7247, 7301, 7305, 7362, 7383, 7406, 7406, 7420, 7445, 7494, 7509, 7523, 7527, 7534, 7541, 7557, 7568, 7623, 7664, 7665, 7681, 7681, 7688, 7691, 7696, 7702, 7714, 7754, 7771, 7784, 7793, 7810, 7811, 7817, 7817, 7832, 7860, 7902, 7905, 7909, 7912, 7926, 7944, 7944, 7975, 8011, 8026, 8027, 8064, 8100, 8162, 8174, 8241, 8261, 8265, 8275, 8323, 8325, 8354, 8384, 8389, 8417, 8422, 8445, 8524, 8547, 8578, 8578, 8601, 8607, 8629, 8662, 8711, 8719, 8723, 8732, 8742, 8784, 8812, 8820, 8821, 8836, 8862, 8891, 8901, 8910, 8930, 8982, 8985, 8999, 9042, 9054, 9070, 9101, 9110, 9139, 9143, 9173, 9177, 9209, 9281, 9300, 9303, 9330, 9334, 9401, 9432, 9435, 9449, 9486, 9550, 9742, 9742, 9784, 9837, 9893, 9904, 9930, 9942, 9962, 9992},
                new int[]{94, 128, 160, 220, 235, 249, 300, 393, 468, 487, 536, 548, 583, 587, 601, 601, 603, 659, 686, 713, 718, 765, 809, 898, 901, 917, 923, 945, 1074, 1112, 1151, 1194, 1233, 1286, 1288, 1314, 1322, 1347, 1403, 1411, 1519, 1614, 1724, 1768, 1824, 1842, 1862, 1877, 1896, 1966, 2061, 2067, 2071, 2094, 2097, 2102, 2104, 2129, 2235, 2284, 2312, 2395, 2434, 2587, 2649, 2655, 2674, 2729, 2758, 2839, 2869, 2902, 2909, 2955, 2960, 3005, 3034, 3043, 3081, 3132, 3152, 3158, 3175, 3177, 3183, 3284, 3332, 3341, 3378, 3428, 3458, 3501, 3515, 3541, 3561, 3574, 3587, 3664, 3684, 3725, 3734, 3744, 3792, 3902, 3931, 3936, 3947, 3979, 4045, 4058, 4064, 4181, 4208, 4262, 4278, 4342, 4415, 4654, 4678, 4747, 4833, 4864, 4901, 4939, 5041, 5064, 5092, 5137, 5140, 5146, 5205, 5220, 5226, 5229, 5322, 5359, 5376, 5428, 5452, 5512, 5533, 5547, 5567, 5672, 5745, 5801, 5802, 5843, 5852, 6068, 6072, 6128, 6140, 6175, 6187, 6190, 6216, 6277, 6306, 6438, 6455, 6495, 6569, 6607, 6609, 6634, 6692, 6739, 6752, 6784, 6825, 6829, 6855, 6862, 6899, 6965, 6976, 7001, 7067, 7087, 7161, 7208, 7252, 7290, 7351, 7420, 7433, 7435, 7435, 7522, 7581, 7647, 7712, 7731, 7749, 7782, 7827, 7839, 7845, 7854, 7893, 7933, 7938, 7969, 8009, 8176, 8228, 8253, 8253, 8276, 8289, 8309, 8323, 8330, 8332, 8343, 8356, 8385, 8391, 8425, 8518, 8572, 8623, 8627, 8635, 8635, 8661, 8715, 8716, 8719, 8776, 8802, 8825, 8830, 8841, 8853, 8884, 8903, 8905, 8907, 8985, 8995, 9018, 9039, 9077, 9093, 9141, 9191, 9214, 9242, 9344, 9444, 9488, 9594, 9602, 9610, 9622, 9640, 9646, 9650, 9705, 9706, 9711, 9760, 9780, 9799, 9813, 9876, 9913, 9937, 9968}));
    }

    public static int minimize(final int[] A, final int[] B, final int[] C) {

        int i = 0;
        int j = 0;
        int k = 0;
        int min;
        int res = Integer.MAX_VALUE;
        while (i < A.length && j < B.length & k < C.length) {

            int max = Math.max(A[i], Math.max(B[j], C[k]));
            min = Math.min(Math.abs(A[i]), Math.min(Math.abs(B[j]), Math.abs(C[k])));

            if (max == 0) {
                res = 0;
                break;
            } else {
                res = Math.min(res, Math.abs(max - min));
            }

            if (A[i] == min) {
                i++;
            } else if (B[j] == min) {
                j++;
            } else if (C[k] == min) {
                k++;
            }
        }
        System.out.println("res " + res);
        return res;
    }


}
