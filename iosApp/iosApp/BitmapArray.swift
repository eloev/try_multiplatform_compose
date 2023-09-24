//
//  BitmapArray.swift
//  iosApp
//
//  Created by Dmitriy Eloev on 24.06.2023.
//  Copyright © 2023 yelloyew. All rights reserved.
//

import Foundation

func mask(from data: [UInt8]) -> UIImage? {
    guard data.count >= 8 else {
        print("data too small")
        return nil
    }

    let width  = Int(data[1]) | Int(data[0]) << 8
    let height = Int(data[3]) | Int(data[2]) << 8

    let colorSpace = CGColorSpaceCreateDeviceGray()

    guard
        data.count >= width * height + 8,
        let context = CGContext(data: nil, width: width, height: height, bitsPerComponent: 8, bytesPerRow: width, space: colorSpace, bitmapInfo: CGImageAlphaInfo.alphaOnly.rawValue),
        let buffer = context.data?.bindMemory(to: UInt8.self, capacity: width * height)
    else {
        return nil
    }

    for index in 0 ..< width * height {
        buffer[index] = data[index + 8]
    }

    return context.makeImage().flatMap { UIImage(cgImage: $0) }
}
