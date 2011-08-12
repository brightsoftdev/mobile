//
//  Category.h
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Category : NSObject {
	NSString *title;
	NSString *tag;
	NSDictionary *subcategories;
}
@property (nonatomic,retain) NSString *title;
@property (nonatomic,retain) NSString *tag;
@property (nonatomic,retain) NSDictionary *subcategories;

@end

