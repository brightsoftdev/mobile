//
//  Categories.h
//  Nellodee
//
//  Created by Ada Hopper on 18/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class Category;

@interface Categories : NSObject {
	NSMutableArray *categories;
}

@property (nonatomic,retain) NSMutableArray *categories;

@end
